package br.com.developer;

public class Main {

    public static void main(String[] args) {

        ChatMediator chat = new ChatMediator();

        Participante eduardo = new ParticipanteImpl("Eduardo", chat);
        Participante joao = new ParticipanteImpl("João", chat);
        Participante maria = new ParticipanteImpl("Maria", chat);


        chat.registrarParticipante(eduardo);
        chat.registrarParticipante(joao);
        chat.registrarParticipante(maria);

        joao.enviaMensagem("Maria", "Olá Maria Tudo bem?");
        maria.enviaMensagem("João", "Tudo bem João e com você?");
        eduardo.enviaMensagem("João", "João, você é um *****");

    }
}
