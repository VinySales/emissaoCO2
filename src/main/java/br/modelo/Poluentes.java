package br.modelo;

public class Poluentes {

    public static final double VALOR_MIN = 0.0;

    private double nmhc;
    private double co;
    private double nox;
    private NotaPBE notaReducaoPoluentes;

    public double getNmhc() {
        return nmhc;
    }

    public void setNmhc(double nmhc) throws IllegalArgumentException{
        if(nmhc <= VALOR_MIN){
            throw new IllegalArgumentException("Valor de de NMHC inválido");
        }
        this.nmhc = nmhc;
    }

    public double getCo() {
        return co;
    }

    public void setCo(double co) throws IllegalArgumentException{
        if (co <= VALOR_MIN){
            throw new IllegalArgumentException("Valor de CO inválido");
        }
        this.co = co;
    }

    public double getNox() {
        return nox;
    }

    public void setNox(double nox) {
        if(nox <= VALOR_MIN){
            throw new IllegalArgumentException("O valor de NOx é inválido");
        }
        this.nox = nox;
    }

    public NotaPBE getNotaReducaoPoluentes() {
        return notaReducaoPoluentes;
    }

    public void setNotaReducaoPoluentes(NotaPBE notaReducaoPoluentes) {
        this.notaReducaoPoluentes = notaReducaoPoluentes;
    }

    @Override
    public String toString() {
        return "Poluentes{" +
                "nmhc=" + nmhc +
                ", co=" + co +
                ", nox=" + nox +
                ", notaReducaoPoluentes=" + notaReducaoPoluentes +
                '}';
    }
}
