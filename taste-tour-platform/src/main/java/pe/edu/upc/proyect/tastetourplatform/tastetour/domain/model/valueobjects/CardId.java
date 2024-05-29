package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects;

public record CardId (Long cardId) {
    public CardId {
        if(cardId < 0){
            throw new IllegalArgumentException("userId cannot be negative");
        }
    }
    public CardId(){
        this(0L);
    }
}
