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

			System.out.printf("%nDados da %d� aula", i+1);
			System.out.printf("%nConte�do ou tarefa (c/t)?");
			char type = sc.nextLine().charAt(0);

			if (Character.toUpperCase(type) == 'C') {
				System.out.printf("T�tulo: ");
				String title = sc.nextLine();
				System.out.printf("URL do v�deo: ");
				String url = sc.nextLine();
				System.out.printf("Dura��o em segundos: ");
				int duration = sc.nextInt();
				sc.nextLine();
				lessonsList.add(new Video(title, url, duration));
			} else {
				System.out.printf("T�tulo: ");
				String title = sc.nextLine();
				System.out.printf("Descri��o: ");
				String description = sc.nextLine();
				System.out.printf("Quantidade de quest�es: ");
				int questionCount = sc.nextInt();
				sc.nextLine();
				lessonsList.add(new Task(title, description, questionCount));
			}

		}
		
		int sum = 0;
		for(Lesson l: lessonsList) {
			sum += l.duration();
		}
		
		System.out.printf("%nDURA��O TOTAL DO CURSO = %d segundos", sum);
		sc.close();
	}
}
