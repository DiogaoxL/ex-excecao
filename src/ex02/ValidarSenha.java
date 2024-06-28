package ex02;

public class ValidarSenha {
    public static void validarSenha(String senha) throws SenhaInvalida{
        if (senha == null || senha.length() < 8 ){
            throw new SenhaInvalida("Senha invalida. Coloque uma senha com pelo menos 8 caracteres!");
        }
    }
}
