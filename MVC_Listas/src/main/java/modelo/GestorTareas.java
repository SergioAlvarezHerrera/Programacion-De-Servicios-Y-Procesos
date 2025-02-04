package modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorTareas {
    private List<Tarea> tareas = new ArrayList<>();
    private int idCounter = 1;

    public void addTask(String description) {
        Tarea nuevaTarea = new Tarea(idCounter++, description);
        tareas.add(nuevaTarea);
    }

    public List<Tarea> getAllTasks() {
        return new ArrayList<>(tareas); // Devolver una copia de la lista
    }

    public Tarea getTaskById(int id) {
        return tareas.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    public void updateTask(int id, String newDescription) {
        Tarea tarea = getTaskById(id);
        if (tarea != null) {
            tarea.setDescription(newDescription);
        }
    }

    public void deleteTask(int id) {
        tareas.removeIf(t -> t.getId() == id);
    }
}