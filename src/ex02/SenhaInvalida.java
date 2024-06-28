package ex02;

public class SenhaInvalida extends Throwable {
    public SenhaInvalida(String mensagem) {
        super(mensagem);
    }
}
