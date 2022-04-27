package demo.demo.jcolibri.server;

//import es.ucm.fdi.gaia.jcolibri.cbrcore.CaseComponent;
import 	demo.demo.jcolibri.cbrcore.Attribute;
import 	demo.demo.jcolibri.cbrcore.CaseComponent;

//import es.ucm.fdi.gaia.jcolibri.method.gui.editors.StringEditor;
//import es.ucm.fdi.gaia.jcolibri.method.retrieve.RetrievalResult;
//import es.ucm.fdi.gaia.jcolibri.connector.TypeAdaptor;
public class CaseDescription implements CaseComponent {

    int id;
    String nip;
    String j, sa;
    double t;
    String ht;
    double gb, crp, pct;
    String rx, sec, msec, tou, dys;
    String aus, des, su, pyu, brm, dsp, lu;
    String fr, kt, abl, infkt;

    public String toString() {
        return "(" + id + ";" + nip + ";" + j + ";" + sa + ";" + t + ";" + ht + ";" + aus + ";" + des + ";" + kt + ";" + abl + ";" + infkt + ";" + sec + ";" + msec + ";" + tou + ";" + dys + ";" + su + ";" + pyu + ";" + brm + ";" + dsp + ";" + fr + ";" + lu + ";" + gb + ";" + crp + ";" + pct + ";" + rx + ")";
    }
	/*public String toString()
	{
		return "("+Id+";"+nip+";"+j+";"+sa+";"+t+";"+ht+";"+gb+";"+crp+";"+pct+";"+rx+";"+sec+";"+msec+";"+tou+";"+dys+";"+aus+";"+des+";"+su+";"+pyu+";"+brm+";"+dsp+";"+lu+";"+fr+";"+kt+";"+abl+";"+infkt+")";
	}*/


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }


    public String getJ() {
        return j;
    }

    public void setJ(String j) {
        this.j = j;
    }


    public String getSa() {
        return sa;
    }

    public void setSa(String sa) {
        this.sa = sa;
    }


    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }


    public String getHt() {
        return ht;
    }

    public void setHt(String ht) {
        this.ht = ht;
    }


    public double getGb() {
        return gb;
    }

    public void setGb(double gb) {
        this.gb = gb;
    }


    public double getCrp() {
        return crp;
    }

    public void setCrp(double crp) {
        this.crp = crp;
    }


    public double getPct() {
        return pct;
    }

    public void setPct(double pct) {
        this.pct = pct;
    }


    public String getRx() {
        return rx;
    }

    public void setRx(String rx) {
        this.rx = rx;
    }

    @Override
    public Attribute getIdAttribute() {
        return null;
    }
}



