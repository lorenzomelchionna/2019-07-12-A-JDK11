package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {
	
	private FoodDao dao;
	
	private Map<Integer,Food> idMap;
	
	private SimpleWeightedGraph<Food,DefaultWeightedEdge> grafo;
	
	public Model() {
		
		dao = new FoodDao();
		
		idMap = new HashMap<>();
		
	}
	
	public void creaGrafo(int n) {
		
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		dao.getFoods(n, idMap);
		
		Graphs.addAllVertices(grafo, idMap.values());
		
		for(Adiacenza a : dao.getAdicanze(idMap)) {
			
			if(!grafo.containsEdge(grafo.getEdge(a.getF1(), a.getF2())))
				Graphs.addEdgeWithVertices(grafo, a.getF1(), a.getF2(), a.getW());
			
		}
		
		
		
	}
	
	public SimpleWeightedGraph<Food,DefaultWeightedEdge> getGrafo(){
		
		return this.grafo;
		
	}
	
	public List<Congiunta> getCongiunta(Food f){
		
		List<Congiunta> result = new ArrayList<>();
		
		for(Food ff : Graphs.neighborListOf(grafo, f)) {
			
			result.add(new Congiunta(ff, grafo.getEdgeWeight(grafo.getEdge(f, ff))));
			
		}
		
		Collections.sort(result);
		
		return result;
		
	}

}
