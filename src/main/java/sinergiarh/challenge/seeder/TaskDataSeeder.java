package sinergiarh.challenge.seeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sinergiarh.challenge.entity.Task;
import sinergiarh.challenge.entity.TaskCategory;
import sinergiarh.challenge.repository.TaskCategoryRepository;
import sinergiarh.challenge.repository.TaskRepository;

@Configuration
public class TaskDataSeeder {
    @Bean
    CommandLineRunner initTaskTable(TaskRepository taskRepository, TaskCategoryRepository taskCategoryRepository) {
        return args -> {
            if (taskRepository.count() == 0) {
                TaskCategory taskCategory = new TaskCategory("PC de escritorio");
                TaskCategory taskCategory2 = new TaskCategory("Notebook");
                TaskCategory taskCategory3 = new TaskCategory("Celulares");
                TaskCategory taskCategory4 = new TaskCategory("Atención al público");

                taskCategoryRepository.save(taskCategory);
                taskCategoryRepository.save(taskCategory2);
                taskCategoryRepository.save(taskCategory3);
                taskCategoryRepository.save(taskCategory4);

                Task task = new Task("Formateo e instalación de SO", taskCategory);
                Task task2 = new Task("Limpieza física", taskCategory);
                Task task3 = new Task("Desinfección de virus", taskCategory);
                Task task4 = new Task("Diagnosticar", taskCategory);
                Task task5 = new Task("Cambio de partes", taskCategory);

                taskRepository.save(task);
                taskRepository.save(task2);
                taskRepository.save(task3);
                taskRepository.save(task4);
                taskRepository.save(task5);

                Task task6 = new Task("Formateo e instalación de SO", taskCategory2);
                Task task7 = new Task("Limpieza física", taskCategory2);
                Task task8 = new Task("Desinfección de virus", taskCategory2);
                Task task9 = new Task("Diagnosticar", taskCategory2);
                Task task10 = new Task("Cambio de partes", taskCategory2);

                taskRepository.save(task6);
                taskRepository.save(task7);
                taskRepository.save(task8);
                taskRepository.save(task9);
                taskRepository.save(task10);

                Task task11 = new Task("Flasheo", taskCategory3);
                Task task12 = new Task("Cambio de batería", taskCategory3);
                Task task13 = new Task("Cambio de pantalla", taskCategory3);
                Task task14 = new Task("Cambio vidrio templado", taskCategory3);

                taskRepository.save(task11);
                taskRepository.save(task12);
                taskRepository.save(task13);
                taskRepository.save(task14);

                Task task15 = new Task("Recibir nuevos clientes", taskCategory4);
                Task task16 = new Task("Presupuestar equipos", taskCategory4);
                Task task17 = new Task("Venta de equipos", taskCategory4);
                Task task18 = new Task("Compra a proveedores", taskCategory4);

                taskRepository.save(task15);
                taskRepository.save(task16);
                taskRepository.save(task17);
                taskRepository.save(task18);
            }
        };
    }
}
