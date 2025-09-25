package com.unisales.interfaces;

public interface Reproduzivel {
    void reproduzir();
    double getDuracao();
    void exibirInfo();
    void exibirInfo(boolean detalhado);
}
/*
 * Interface: Crie uma interface chamada Reproduzivel com os seguintes métodos:
void reproduzir(): Método abstrato para simular a reprodução da mídia.
double getDuracao(): Método para retornar a duração estimada da mídia (em minutos).
void exibirInfo(): Método abstrato para mostrar informações da mídia.
void exibirInfo(boolean detalhado): Método abstrato para mostrar informações da mídia com detalhes.
 */