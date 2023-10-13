package ExamePraticoExemploRui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BaseCatalogAdmin implements CatalogAdmin {

    public HashMap<String, Servico> catalogoServicos = new HashMap<>();
    public HashMap<String, PacoteServicos> catalogoServicos2 = new HashMap<>();
    
    
    public Boolean registarServico(String codigo, PacoteServicos p) {
        Boolean retVal = false;
        
        if (!catalogoServicos2.containsKey(codigo)) {
            catalogoServicos2.put(codigo, p);
            retVal = true;
        }
        else {
            catalogoServicos2.remove(codigo);
            catalogoServicos2.put(codigo, p);
            retVal = true;
        }
        return retVal;
    }
    
    @Override
    public Boolean registarServico(String codigo, Servico servico) {
        Boolean retVal = false;
        
        if (!catalogoServicos.containsKey(codigo)) {
            catalogoServicos.put(codigo, servico);
            retVal = true;
        }
        else {
            catalogoServicos.remove(codigo);
            catalogoServicos.put(codigo, servico);
            retVal = true;
        }
        return retVal;
    }

    @Override
    public Boolean verificarServico(String codigo) {
        Boolean retVal = false;
        
        for (String i : catalogoServicos.keySet() ) {
            if (i.equals(codigo)) {
                retVal = true;
            }
        }
        return retVal;
    }

    @Override
    public Servico removerServico(String codigo) {
        Servico s = catalogoServicos.get(codigo);
        catalogoServicos.remove(codigo);
        return s;
    }

    @Override
    public Servico selecionarServico(String codigo) {
        return catalogoServicos.get(codigo);
    }

    @Override
    public Iterator<String> iterator() {
        ArrayList<String> lista = new ArrayList<>();

        for (Servico i : catalogoServicos.values()) {
            lista.add(i.toString());
        }
    
        return lista.iterator();
    }
}