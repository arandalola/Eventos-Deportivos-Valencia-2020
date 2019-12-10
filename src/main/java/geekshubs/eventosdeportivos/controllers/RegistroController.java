package geekshubs.eventosdeportivos.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import geekshubs.eventosdeportivos.entities.Evento;
import geekshubs.eventosdeportivos.entities.Registro;
import geekshubs.eventosdeportivos.entities.Usuario;
import geekshubs.eventosdeportivos.entities.UsuarioEvento;
import geekshubs.eventosdeportivos.repositories.EventoRepository;
import geekshubs.eventosdeportivos.repositories.RegistroRepository;
import geekshubs.eventosdeportivos.repositories.UsuarioRepository;
import geekshubs.eventosdeportivos.services.RegistroErrorException;
import geekshubs.eventosdeportivos.services.RegistroException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
@RestController
@CrossOrigin(origins = "http://localhost")
@RequestMapping("/v1")
public class RegistroController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RegistroErrorException.class,NumberFormatException.class})
    public final ResponseEntity<RegistroException>
    registroError(Exception ex) throws JsonProcessingException {
        RegistroException exceptionResponse=null;
        HttpStatus status=HttpStatus.BAD_REQUEST;
        if(ex.getClass()==NumberFormatException.class){
            exceptionResponse=
                    new RegistroException("id no numerico",
                            "El id solo puede contener números positivos");
            status=HttpStatus.FORBIDDEN;
        }else{
            exceptionResponse=
                    new RegistroException(ex.getMessage(),
                            "El id no puede tener un valor negativo");
        }
        return new ResponseEntity<RegistroException>
                (exceptionResponse, new HttpHeaders(), status);
    }

    @Autowired
    RegistroRepository registroRepo;
    @Autowired
    UsuarioRepository usuarioRepo;
    @Autowired
    EventoRepository eventoRepo;

    @GetMapping("/registros")
    public List<Registro> listRegistro(){
        return registroRepo.findAll();
    }

    @GetMapping("/registros/{id}")
    public Registro detailRegistro(@PathVariable String id){
        if(Integer.parseInt(id)<0) throw new RegistroErrorException("id negativo");
        return registroRepo.findById(Long.parseLong(id)).orElse(null);
    }

    @PostMapping("/registros")
    public Registro createRegistro(@RequestBody UsuarioEvento usuarioEvento){
        Usuario usuario = usuarioRepo.findById(usuarioEvento.getIdUsuario()).orElse(null);
        Evento evento =eventoRepo.findById((usuarioEvento.getIdEvento())).orElse(null);
        Registro registro = new Registro(usuario,evento);
        return registroRepo.save(registro);
    }

    @DeleteMapping("/registros/{id}")
    public void deleteRegistro(@PathVariable("id") Long id){
        registroRepo.deleteById(id);
    }
}
