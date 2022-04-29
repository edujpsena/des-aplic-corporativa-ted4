package br.com.developer;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ChatMediator implements Mediator{

    private Hashtable<String, Participante> participantes = new Hashtable<>();

    private List<String> palavrasProibidas = new ArrayList<>();

    public ChatMediator() {
        palavrasProibidas.add("#####");
        palavrasProibidas.add("@@@@@");
        palavrasProibidas.add("*****");
    }

    public void registrarParticipante(Participante p) {
        if(participantes.containsKey(p.getNome())) {
            System.out.println("Usuário já cadastrado");
        } else {
            participantes.put(p.getNome(), p);
        }
    }

    @Override
    public void enviaMensagem(String remetente, String destinatario, String mensagem) {

        if (participantes.containsKey(remetente) && participantes.containsKey(destinatario)) {
            Participante pRemetente = participantes.get(remetente);
            Participante pDestinatario = participantes.get(destinatario);

            for (String proibido: palavrasProibidas) {
                if (mensagem.contains(proibido)) {
                    pRemetente.recebeMensagem("Mediador", "Você escreveu uma mensagem contendo palavras impróprias.");
                    return;
                }
            }

            pDestinatario.recebeMensagem(remetente, mensagem);
        }
    }
}
