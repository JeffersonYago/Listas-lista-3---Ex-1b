package controller;

import model.Fila;
import model.Lista;

public class Ex1bController {

	public Ex1bController() {
		super();
	}

	public void carregarLista(){
		Lista<Integer> lista = new Lista<>();
		lista.addFirst(10);
		try {
		lista.addLast(5);
		lista.addLast(8);
		lista.addLast(1);
		lista.addLast(9);
		lista.addLast(2);
		lista.addLast(4);
		lista.addLast(7);
		lista.addLast(3);
		lista.addLast(6);
	}catch (Exception e) {
	}
		manipulaLista(lista);
	}

	private void manipulaLista(Lista<Integer> lista) {
		Fila<Integer> fila = new Fila<>();
		int tamanho = lista.size();
		int [] vet = new int [tamanho];
		int percorrer = 0;
		try {
		while(!lista.isEmpty()) {
			vet[percorrer] = lista.get(0);
			lista.removeFirst();
			percorrer++;
		}
		for(int i = 0; i < tamanho; i++) {
			for(int j = i+1; j < tamanho; j++) {
			if(vet[i] > vet[j]) {
				int aux = vet[i];
				vet[i] = vet[j];
				vet[j] = aux;
			}
		}
		}
		for(int i: vet) {
			fila.insert(i);
		}
		while(!fila.isEmpty()) {
			if(lista.isEmpty()) {
				lista.addFirst(fila.remove());
			}else {
				lista.addLast(fila.remove());
			}
		}
		percorrer = 0;
		while(percorrer < lista.size()) {
			System.out.print("["+lista.get(percorrer)+"] "+"--> ");
			percorrer++;
		}
	}catch (Exception e) {
	}
	}
}