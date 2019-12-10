package geekshubs.eventosdeportivos.services;

public class UsuarioErrorException extends RuntimeException {
    public UsuarioErrorException(String msg){
        super(msg);
    }
}
