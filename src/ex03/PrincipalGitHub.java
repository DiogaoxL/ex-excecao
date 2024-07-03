package ex03;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalGitHub {
    public static void main(String[] args) throws IOException, InterruptedException, ErroConsultaGitHubException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual usuario deseja pesquisar? ");
        String user = sc.next();

        String endereco = "https://api.github.com/users/" + user;

       // String endereco = "https://api.github.com/users/" + user;


        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                    String json = response.body();
                    if (response.statusCode() == 404){
                        throw new ErroConsultaGitHubException("Usuario não encontrado no github");
                    }

                    Gson gson = new Gson();
                    UsuarioGitHub usuario = gson.fromJson(json, UsuarioGitHub.class);

                    System.out.println("Nome: " + usuario.name());
                    System.out.println("Login: " + usuario.login());
                    System.out.println("Id: " + usuario.id());


            }catch (IOException | InterruptedException e){
                System.out.println("Aconteceu um erro na conexão da API");
                e.printStackTrace();
            }catch (ErroConsultaGitHubException e){
            System.out.println(e.getMessage());
        }


    }
}
