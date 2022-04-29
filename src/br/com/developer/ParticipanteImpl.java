package br.com.developer;

public class ParticipanteImpl extends Participante{

    public ParticipanteImpl(String nome, Mediator mediator) {
        super(nome, mediator);
    }

    @Override
    public void enviaMensagem(String destinatario, String mensagem) {
        Mediator mediator = this.getMediator();
        mediator.enviaMensagem(this.getNome(), destinatario, mensagem);
    }

    @Override
    public void recebeMensagem(String remetente, String mensagem) {
        System.out.println(remetente + " escreveu: " + mensagem);
    }
}
