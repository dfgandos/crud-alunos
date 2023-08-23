package com.crud.projectcrud.controller;

import com.crud.projectcrud.repository.EnderecoRepository;
import com.crud.projectcrud.repository.InfoAlunosRepository;
import com.crud.projectcrud.repository.PeriodoRepository;
import com.crud.projectcrud.interfaceservice.CursoInterfSer;
import com.crud.projectcrud.interfaceservice.InfoAlunosInterfServ;
import com.crud.projectcrud.interfaceservice.PeriodoInterfServ;
import com.crud.projectcrud.model.Curso;
import com.crud.projectcrud.model.InfoAlunos;
import com.crud.projectcrud.model.Periodo;
import com.crud.projectcrud.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private InfoAlunosInterfServ servicealuno;

    @Autowired
    private InfoAlunosRepository repoalunos;

    @Autowired
    private CursoInterfSer servicecurso;

    @Autowired
    private CursoRepository repocurso;

    @Autowired
    private PeriodoInterfServ serviceperiodo;

    @Autowired
    private PeriodoRepository repoperiodo;

    @Autowired
    private EnderecoRepository repoendereco;

    @GetMapping("/login")
    public String Login(){
        return "login";
    }

    @GetMapping("/")
    public String Index(Model model){

        List <InfoAlunos> infoalunos = servicealuno.listar();
        model.addAttribute("infoalunos", infoalunos);

        return "index";
    }

    @GetMapping(value = "/{matricula}")
    public String userView(@PathVariable("matricula") Integer matricula, Model model){

        InfoAlunos aluno = repoalunos.findById(matricula).get();
        model.addAttribute("infoalunos", aluno);

        return "index";
    }

    @GetMapping("/Cadastrar")
    public String Cadastrar(Model model){

        InfoAlunos infoalunos = new InfoAlunos();
        model.addAttribute("info_alunos",infoalunos);

        List<Curso> cursos = servicecurso.listar();
        model.addAttribute("cursos", cursos);

        List<Periodo> periodos = serviceperiodo.listar();
        model.addAttribute("periodos", periodos);

        return "cadastrar-editar/cadastro";
    }

    @GetMapping(value = "/Cadastrar/Sucesso")
    public String SucessForm(){
        return "cadastrar-editar/Sucesso";
    }

    @GetMapping(value = "/editar/{matricula}")
    public String EditForm(@PathVariable("matricula") Integer matricula,Model model){

        Optional<InfoAlunos> aluno = repoalunos.findById(matricula);
        model.addAttribute("pessoaobj", aluno.get());

        List<Curso> cursos = servicecurso.listar();
        model.addAttribute("cursos", cursos);

        List<Periodo> periodos = serviceperiodo.listar();
        model.addAttribute("periodos", periodos);

        return "cadastrar-editar/editar";
    }

    @GetMapping(value = "/remove/{matricula}")
    public String deleteForm(@PathVariable("matricula") Integer matricula){

        InfoAlunos aluno = repoalunos.findById(matricula).get();
        repoendereco.delete(aluno.getEndereco());
        repoalunos.delete(aluno);

        return "redirect:/";
    }

    @PostMapping(value = "/salvar")
    public String CadastroForm(@ModelAttribute ("info_alunos") InfoAlunos infoalunos){

        repoendereco.save(infoalunos.getEndereco());
        repoalunos.save(infoalunos);

        return "redirect:Cadastrar/Sucesso";
    }

    @PostMapping(value = "/editar")
    public String EditarForm(@ModelAttribute ("info_alunos") InfoAlunos infoalunos){

        repoendereco.save(infoalunos.getEndereco());
        repoalunos.save(infoalunos);

        return "redirect:/";
    }
}
