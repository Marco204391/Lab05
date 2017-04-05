package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.WordDAO;

public class Model {

	private List<String> permutations;
	List<String> listResult = null;
	
	public List<String> findPermutations(String word) {
	
	permutations = new ArrayList<String>();	
	//chiamo la funzione ricorsiva
	int step=0;
	recursive(word, step);
	
	//ritorno tutte le soluzione trovate
	return permutations;

	}
	
	private void recursive(String word, int step){
		
		if (step == word.length()) {
			permutations.add(word);
			return;
		}

		for (int i = step; i < word.length(); i++) {

			char[] chars = word.toCharArray();

			// Genero una nuova soluzione
			char temp = chars[step];
			chars[step] = chars[i];
			chars[i] = temp;

			// Richiamo la funzione ricorsiva
			recursive(String.valueOf(chars), step + 1);

			// Trasformando l'array di chars non è necessario fare backtrack.
		}
	}

	private List<String> permutationsFind(String word){
		return listResult = findPermutations(word);
		
	}
	
	public boolean isCorrect(String word) {
		WordDAO dao=new WordDAO();
		return dao.isCorrect(word);
	}
}
