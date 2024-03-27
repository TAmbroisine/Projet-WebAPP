import { Component, inject } from "@angular/core"
import { map, Observable } from "rxjs"
import { Student } from "models/student.model"
import { ActivatedRoute, Router } from "@angular/router"
import { StudentService } from "services/student.service"

@Component({
  selector: "students",
  templateUrl: "./cart.component.html",
  styleUrls: ["./cart.component.scss"],
})

export class CartComponent {

  constructor(private _route: ActivatedRoute, private studentService: StudentService, private router: Router) {}

  
  students$: Observable<Student[]> =  this.studentService.findAll()

  deleteStudent(event: any, student: Student) {
    event.stopPropagation()
    this.studentService.delete(student).subscribe(() => this.router.navigate(["students"]))
  }

  searchByMajorAndCourse($event: Observable<Student[]>) {
    this.students$ = $event
  }
}
