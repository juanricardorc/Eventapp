package com.jualig.datasource.repository.model;

import java.util.LinkedList;
import java.util.List;

public class Event {
    private String id;
    private String image;
    private String name;
    private String description;

    public Event() {

    }

    public Event(String id, String image, String name, String description) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static List<Event> gets() {
        List<Event> events = new LinkedList<>();
        events.add(new Event(
                "1",
                "https://querecetas.net/wp-content/uploads/2019/03/Causa-rellena-de-Pollo.jpg",
                "I CONECIT 2017, Tingo María",
                "Congreso Nacional de Estudiantes, Perú"));

        events.add(new Event(
                "2",
                "https://s3.amazonaws.com/cdn.matadornetwork.com/blogs/2/2015/07/arroz_con_pollo.jpg",
                "Java vs Kotlin",
                "Java 8 vs Kotlin 1.3"));

        events.add(new Event(
                "3",
                "https://www.ecestaticos.com/imagestatic/clipping/850/ca4/850ca4f2d62221b11dc7653750623df2/por-que-tomar-sopa-durante-las-comidas-logra-que-adelgaces.jpg",
                "Android Jetpack",
                "Architecture Components"));

        events.add(new Event(
                "4",
                "https://i.pinimg.com/originals/61/f2/eb/61f2ebef1e6159202ee33a9c9a5dea89.jpg",
                "Clean Architecture",
                "El tío Bob"));

        events.add(new Event(
                "5",
                "https://www.vinetur.com/imagenes/2017/octubre/2/vino_comida.jpg",
                "Model Vista Presentador",
                "Patron de Diseño M"));

        events.add(new Event(
                "6",
                "https://www.vinetur.com/imagenes/2017/octubre/2/vino_comida.jpg",
                "Patrones de Diseño",
                "MVC, MVP, MVVM"));
        return events;
    }
}
