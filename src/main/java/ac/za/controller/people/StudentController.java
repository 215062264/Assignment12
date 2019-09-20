package ac.za.controller.people;

import ac.za.domain.people.Student;
import ac.za.service.serviceInterface.people.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService service;


    @PostMapping("/create")
    @ResponseBody
    public Student create(@RequestBody Student student) {return service.create(student); }

    @PutMapping("/update")
    @ResponseBody
    public Student update(@RequestBody Student student) {
        return service.update(student);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Student read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Student> getAll() {
        return service.getAll();
    }
}
