package br.com.spolador.consultasdinamicas.controller;

import br.com.spolador.consultasdinamicas.domain.Student;
import br.com.spolador.consultasdinamicas.dto.RequestDto;
import br.com.spolador.consultasdinamicas.repository.StudentRepository;
import br.com.spolador.consultasdinamicas.service.FilterSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/filter")
public class FilterController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FilterSpecification<Student> studentFilterSpecification;

    @GetMapping("/{name}")
    public Student getStudentByName(@PathVariable(name = "name") String name){
        return studentRepository.findByName(name);
    }

    @GetMapping("city/{CITY}")
    public List<Student> getStudentByCity(@PathVariable(name = "CITY") String city){
        return studentRepository.findByAdressCity(city);
    }

    @GetMapping("subject/{SUB}")
    public List<Student> getStudentBySubject(@PathVariable(name = "SUB") String subject){
        return studentRepository.findBySubjectsName(subject);
    }

//    @PostMapping("/specification")
//    public List<Student> getStudents(){
//        Specification<Student> specification = new Specification<>() {
//
//            @Override
//            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                return criteriaBuilder.equal(root.get("name"), "Jose");
//            }
//        };
//        List<Student> all = studentRepository.findAll(specification);
//        return all;
//    }

    @PostMapping("/specification")
    public List<Student> getStudents(@RequestBody RequestDto requestDto){
        Specification<Student> searchSpecification = studentFilterSpecification.getSearchSpecification(requestDto.getSearchRequestDto(), requestDto.getGlobalOperator());
        return studentRepository.findAll(searchSpecification);
    }
}
