import br.com.dio.vitor.dominio.Bootcamp;
import br.com.dio.vitor.dominio.Curso;
import br.com.dio.vitor.dominio.Dev;
import br.com.dio.vitor.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Curso curso1 = new Curso();

        System.out.println("Digite o nome do curso a ser cadastrado: ");
        curso1.setTitulo(input.nextLine());

        System.out.println("Descreva o curso: ");
        curso1.setDescricao(input.nextLine());

        System.out.println("Qual a carga horária do curso? ");
        curso1.setCargaHoraria(input.nextInt());
        input.nextLine();

        Curso curso2 = new Curso();

        System.out.println("Digite o nome do novo curso a ser cadastrado: ");
        curso2.setTitulo(input.nextLine());

        System.out.println("Descreva o curso: ");
        curso2.setDescricao(input.nextLine());

        System.out.println("Qual a carga horária do curso? ");
        curso2.setCargaHoraria(input.nextInt());
        input.nextLine();


        Mentoria mentoria = new Mentoria();

        System.out.println("Digite o nome da mentoria a ser cadastrada: ");
        mentoria.setTitulo(input.nextLine());

        System.out.println("Descreva a mentoria: ");
        mentoria.setDescricao(input.nextLine());
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();

        System.out.println("Informe o nome do Bootcamp a ser cadastrado: ");
        bootcamp.setNome(input.nextLine());

        System.out.println("Descreva o Bootcamp: ");
        bootcamp.setDescricao(input.nextLine());
        bootcamp.adicionarConteudo(curso1);
        bootcamp.adicionarConteudo(curso2);
        bootcamp.adicionarConteudo(mentoria);

        Dev devVitor = new Dev();

        System.out.println("Informe o nome do desenvolvedor a ser cadastrado: ");
        devVitor.setNome(input.nextLine());
        devVitor.inscreverBootcamp(bootcamp);

        System.out.println("Conteúdos Inscritos Vitor:" + devVitor.getConteudosInscritos());
        devVitor.progredir();
        devVitor.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Vitor:" + devVitor.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Vitor:" + devVitor.getConteudosConcluidos());
        System.out.println("XP:" + devVitor.calcularTotalXp());

        System.out.println("-------");

        Dev devJoao = new Dev();

        System.out.println("Informe o nome do novo desenvolvedor a ser cadastrado: ");
        devJoao.setNome(input.nextLine());
        devJoao.inscreverBootcamp(bootcamp);

        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
        System.out.println("XP:" + devJoao.calcularTotalXp());

    }

}