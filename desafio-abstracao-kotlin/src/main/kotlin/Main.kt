import java.text.SimpleDateFormat

fun main() {

    val listaDeConteudosEducacionais = mutableListOf<ConteudoEducacional>()

    val conteudoUm = ConteudoEducacional("Fundamentos Basicos Kotlin", 60, Nivel.BASICO)
    listaDeConteudosEducacionais.add(conteudoUm)

    val conteudoDois = ConteudoEducacional("Fundamentos Intermediarios Kotlin", 90, Nivel.INTERMEDIARIO)
    listaDeConteudosEducacionais.add(conteudoDois)

    val conteudoTres = ConteudoEducacional("Fundamentos Avancados Kotlin", 120, Nivel.AVANCADO)
    listaDeConteudosEducacionais.add(conteudoTres)

    val formacaoEmKotlin = Formacao("Kotlin", conteudos = listaDeConteudosEducacionais, 120)


    println("Qual o seu nome?")
    val nomeAluno = readLine()

    println("E o seu email?")
    val email = readLine()

    val formato = SimpleDateFormat("dd/MM/yyyy")
    println("Digite sua data de nascimento no formato (dd/MM/yyyy)")
    val  dataDeNascimento = formato?.parse(readLine())


    val alunoDio = Usuario(nomeAluno.toString(), email.toString(), dataDeNascimento)

    alunoDio.adicionarPontos(1000)
    alunoDio.adicionarFormacao(formacaoEmKotlin)

    println(alunoDio.nome)
    println(alunoDio.email)
    println(alunoDio.dataNascimento)
    println(alunoDio.formacoes)
    println(alunoDio.pontuacao)

}