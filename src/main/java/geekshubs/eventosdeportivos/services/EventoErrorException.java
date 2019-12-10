package geekshubs.eventosdeportivos.services;

public class EventoErrorException extends RuntimeException {
    public EventoErrorException(String msg){
        super (msg);
    }
}
