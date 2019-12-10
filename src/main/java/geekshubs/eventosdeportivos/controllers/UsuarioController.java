package geekshubs.eventosdeportivos.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import geekshubs.eventosdeportivos.entities.Usuario;
import geekshubs.eventosdeportivos.repositories.RegistroRepository;
import geekshubs.eventosdeportivos.repositories.UsuarioRepository;
import geekshubs.eventosdeportivos.services.EventoErrorException;
import geekshubs.eventosdeportivos.services.UsuarioErrorException;
import geekshubs.eventosdeportivos.services.UsuarioException;
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
@RequestMapping("/v1")
public class UsuarioController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UsuarioErrorException.class,NumberFormatException.class})
    public final ResponseEntity<UsuarioException>
    usuarioError(Exception ex) throws JsonProcessingException {
        UsuarioException exceptionResponse=null;
        HttpStatus status=HttpStatus.BAD_REQUEST;
        if(ex.getClass()==NumberFormatException.class){
            exceptionResponse=
                    new UsuarioException("id no numerico",
                            "El id solo puede contener números positivos");
            status=HttpStatus.FORBIDDEN;
        }else{
            exceptionResponse=
                    new UsuarioException(ex.getMessage(),
                            "El id no puede tener un valor negativo");
        }
        return new ResponseEntity<UsuarioException>
                (exceptionResponse, new HttpHeaders(), status);
    }

    @Autowired
    UsuarioRepository usuarioRepo;
    @Autowired
    RegistroRepository registroRepo;

    @GetMapping("/usuarios")
    public List<Usuario> listUsuario(){
        return usuarioRepo.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario detailUsuario(@PathVariable String id){
        if(Integer.parseInt(id)<0) throw new EventoErrorException("id negativo");
        return usuarioRepo.findById(Long.parseLong(id)).orElse(null);
    }

    @PostMapping("/usuarios")
    public void createUsuario(@RequestBody Usuario usuario){
        usuarioRepo.save(usuario);
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepo.findById(id);
        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            usuario.setId(id);
            usuarioRepo.save(usuario);
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("usuarios/{id}")
    public void deleteUsuario(@PathVariable("id") Long id){
        usuarioRepo.deleteById(id);
    }
}
