import java.util.Date

class Usuario(val nome : String, val email : String, val dataNascimento : Date){
    var pontuacao : Int = 0
    var formacoes : MutableList<Formacao> = mutableListOf()

    constructor(nome: String, email: String, dataNascimento: Date, pontuacao: Int, formacao: Formacao) : this(
        "","",Date()
    )


    fun adicionarPontos(pontos : Int){
        pontuacao += pontos
    }
    fun adicionarFormacao(formacao : Formacao){
        formacoes.add(formacao)
    }
}