package geekshubs.eventosdeportivos.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import geekshubs.eventosdeportivos.entities.Evento;
import geekshubs.eventosdeportivos.repositories.EventoRepository;
import geekshubs.eventosdeportivos.repositories.RegistroRepository;
import geekshubs.eventosdeportivos.services.EventoErrorException;
import geekshubs.eventosdeportivos.services.EventoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Optional;

@ControllerAdvice
@RestController
@CrossOrigin(origins = "http://localhost")
@RequestMapping ("/v1")
public class EventoController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EventoErrorException.class,NumberFormatException.class})
    public final ResponseEntity<EventoException>
    eventoError(Exception ex) throws JsonProcessingException{
        EventoException exceptionResponse=null;
        HttpStatus status=HttpStatus.BAD_REQUEST;
        if(ex.getClass()==NumberFormatException.class){
            exceptionResponse=
                    new EventoException("id no numerico",
                            "El id solo puede contener números positivos");
            status=HttpStatus.FORBIDDEN;
        }else{
            exceptionResponse=
                    new EventoException(ex.getMessage(),
                            "El id no puede tener un valor negativo");
        }
        return new ResponseEntity<EventoException>
                (exceptionResponse, new HttpHeaders(), status);
    }

    @Autowired
    EventoRepository eventoRepo;
    @Autowired
    RegistroRepository registroRepo;

    @GetMapping("/eventos")
    public List<Evento> listEvento(){
        return eventoRepo.findAll();
    }

    @GetMapping("/eventos/{id}")
    public Evento detailEvento(@PathVariable String id){
        if(Integer.parseInt(id)<0) throw new EventoErrorException("id negativo");
        return eventoRepo.findById(Long.parseLong(id)).orElse(null);
    }

    @PostMapping("/eventos")
    public void createEvento(@RequestBody Evento evento){
        eventoRepo.save(evento);
    }

    @PutMapping("/eventos/{id}")
    public ResponseEntity<Evento> updateEvento(@RequestBody Evento evento, @PathVariable Long id){
        Optional<Evento> eventoOptional = eventoRepo.findById(id);
        if(!eventoOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }else {
            evento.setId(id);
            eventoRepo.save(evento);
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("eventos/{id}")
    public void deleteEvento(@PathVariable("id") Long id){
        eventoRepo.deleteById(id);
    }

    @GetMapping("/error")
    public String errorServiceEvento() {
        throw new RuntimeException("Un error ha sucedido");
    }
}
