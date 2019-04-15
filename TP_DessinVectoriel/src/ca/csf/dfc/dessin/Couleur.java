package ca.csf.dfc.dessin;

public class Couleur {
    private int m_rouge, m_vert, m_bleu, m_alpha;

    public Couleur(int rouge, int vert, int bleu, int alpha) {
        this.m_rouge = rouge;
        this.m_vert = vert;
        this.m_bleu = bleu;
        this.m_alpha = alpha;
    }

    public int getRouge() {
        return m_rouge;
    }

    public void setRouge(int rouge) {
        this.m_rouge = rouge;
    }

    public int getVert() {
        return m_vert;
    }

    public void setVert(int vert) {
        this.m_vert = vert;
    }

    public int getBleu() {
        return m_bleu;
    }

    public void setBleu(int bleu) {
        this.m_bleu = bleu;
    }

    public int getAlpha() {
        return m_alpha;
    }

    public void setAlpha(int alpha) {
        this.m_alpha = alpha;
    }
}
