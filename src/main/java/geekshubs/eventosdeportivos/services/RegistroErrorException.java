package geekshubs.eventosdeportivos.services;

public class RegistroErrorException extends RuntimeException {
    public RegistroErrorException(String msg){
        super(msg);
    }
}
