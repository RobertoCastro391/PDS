package ExamePraticoExemploRui;

public interface CatalogAdmin extends Iterable<String> {
    Boolean registarServico(String codigo, Servico servico);
    Boolean verificarServico(String codigo);
    Servico removerServico(String codigo);
    Servico selecionarServico(String codigo);
}