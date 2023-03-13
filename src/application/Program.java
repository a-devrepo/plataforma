package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int lessons = 0;
		List<Lesson> lessonsList = new ArrayList<Lesson>();

		System.out.printf("Quantas aulas tem o curso? ");
		lessons = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < lessons; i++) {

			System.out.printf("%nDados da %dª aula", i+1);
			System.out.printf("%nConteúdo ou tarefa (c/t)?");
			char type = sc.nextLine().charAt(0);

			if (Character.toUpperCase(type) == 'C') {
				System.out.printf("Título: ");
				String title = sc.nextLine();
				System.out.printf("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.printf("Duração em segundos: ");
				int duration = sc.nextInt();
				sc.nextLine();
				lessonsList.add(new Video(title, url, duration));
			} else {
				System.out.printf("Título: ");
				String title = sc.nextLine();
				System.out.printf("Descrição: ");
				String description = sc.nextLine();
				System.out.printf("Quantidade de questões: ");
				int questionCount = sc.nextInt();
				sc.nextLine();
				lessonsList.add(new Task(title, description, questionCount));
			}

		}
		
		int sum = 0;
		for(Lesson l: lessonsList) {
			sum += l.duration();
		}
		
		System.out.printf("%nDURAÇÃO TOTAL DO CURSO = %d segundos", sum);
		sc.close();
	}
}
