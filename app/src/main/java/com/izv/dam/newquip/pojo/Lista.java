package com.izv.dam.newquip.pojo;
import android.content.ContentValues;

import android.os.Parcel;
import android.os.Parcelable;

import com.izv.dam.newquip.contrato.ContratoBaseDatos;

/**
 * Created by Nono on 10/10/2016.
 */

public class Lista implements Parcelable {
    private long id_lista, id_nota;
    private String texto_lista;
    private boolean hecho;

    public long getId_lista() {
        return id_lista;
    }

    public void setId_lista(long id_lista) {
        this.id_lista = id_lista;
    }

    @Override
    public String toString() {
        return "Lista{" +
                "id_lista=" + id_lista +
                ", id_nota=" + id_nota +
                ", texto_lista='" + texto_lista + '\'' +
                ", hecho=" + hecho +
                '}';
    }

    public long getId_nota() {
        return id_nota;
    }

    public void setId_nota(long id_nota) {
        this.id_nota = id_nota;
    }

    public String getTexto_lista() {
        return texto_lista;
    }

    public void setTexto_lista(String texto_lista) {
        this.texto_lista = texto_lista;
    }

    public boolean isHecho() {
        return hecho;
    }

    public void setHecho(boolean hecho) {
        this.hecho = hecho;
    }

    public Lista(long id_lista, long id_nota, String texto_lista, boolean hecho) {
        this.id_lista = id_lista;
        this.id_nota = id_nota;
        this.texto_lista = texto_lista;
        this.hecho = hecho;
    }

    public Lista() {
        this(0, 0, null, false);
    }

    /*
     * Metodos que la clase parcelable usa
     */
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id_lista);
        dest.writeLong(id_nota);
        dest.writeString(texto_lista);
        //        dest.writeBooleanArray(hecho); //no hay metodo  writeBoolean()
    }

    /*
     * Metodo de la clase parcelabre que necesita lista
     */
    protected Lista(Parcel in) {
        id_lista = in.readLong();
        id_nota = in.readLong();
        texto_lista = in.readString();
        hecho = in.readByte() != 0;
    }

    public static final Creator<Lista> CREATOR = new Creator<Lista>() {
        @Override
        public Lista createFromParcel(Parcel in) {
            return new Lista(in);
        }

        @Override
        public Lista[] newArray(int size) {
            return new Lista[size];
        }
    };
}
