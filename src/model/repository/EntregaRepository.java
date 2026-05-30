package model.repository;

import model.entity.Entrega;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EntregaRepository {

    private HashMap<Integer, Entrega> mapa = new HashMap<>();

    public void salvar(Entrega entrega){
        mapa.put(entrega.getId(), entrega);
    }

    public Entrega buscarPorId(int id){
        return mapa.get(id);
    }

    public List<Entrega> listar(){
        return new ArrayList<>(mapa.values());
    }

    public void remover(int id){
        mapa.remove(id);
    }

}