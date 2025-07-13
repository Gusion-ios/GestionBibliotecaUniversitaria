import java.util.ArrayList;

import java.util.List;



public abstract class Multimedia {



    protected int codigo;

    protected String titulo;

    protected String autor;

    protected boolean disponible;

    protected CategoriaMultimedia categoriaMultimedia;

    protected static List<Multimedia> listaRecursos = new ArrayList<>();



    public Multimedia(int codigo, String titulo, String autor, boolean disponible, CategoriaMultimedia categoriaMultimedia) {

        this.codigo = codigo;

        this.titulo = titulo;

        this.autor = autor;

        this.disponible = disponible;

        this.categoriaMultimedia = categoriaMultimedia;

        listaRecursos.add(this);

    }



    public int getCodigo() {

        return codigo;

    }

    public void setCodigo(int codigo) {

        this.codigo = codigo;

    }

    public String getTitulo() {

        return titulo;

    }

    public String getAutor() {

        return autor;

    }

    public void setAutor(String autor) {

        this.autor = autor;

    }

    public void setTitulo(String titulo) {

        this.titulo = titulo;

    }

    public boolean isDisponible() {

        return disponible;

    }

    public void setDisponible(boolean disponible) {

        this.disponible = disponible;

    }

    public CategoriaMultimedia getCategoriaMultimedia() {

        return categoriaMultimedia;

    }

    public void setCategoriaMultimedia(CategoriaMultimedia categoriaMultimedia) {

        this.categoriaMultimedia = categoriaMultimedia;

    }



    public void prestar() {

        if (disponible) {

            disponible = false;

        } else {

            System.out.println("El recurso ya está prestado");

        }

    }



    public void devolver() {

        disponible = true;

    }



    public abstract void mostrarInfo();



    public static void mostrarTodosLosRecursos() {

        for (Multimedia recurso : listaRecursos) {

            recurso.mostrarInfo();

            System.out.println("-------------------------");

        }

    }



}

