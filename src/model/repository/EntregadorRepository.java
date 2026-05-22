package model.repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;

import model.entity.Entregador;

public class EntregadorRepository {

    HashMap<Integer, Entregador> mapa = new HashMap<>();

    public void salvar(Entregador entregador){
        mapa.put(entregador.getId(), entregador);
    }

    public Entregador buscarPorID(int id){ return mapa.get(id); }

    public List<Entregador> listar(){ return new ArrayList<>(mapa.values()); }
}
