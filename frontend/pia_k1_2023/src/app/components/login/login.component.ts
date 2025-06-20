import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth/auth.service';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterModule, HttpClientModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  loginForm: any;
  errorMessage: string = '';

  constructor(private http: HttpClient, private router: Router,
    private authService: AuthService, private fb: FormBuilder) {
      this.loginForm = this.fb.group({
        username : ['', Validators.required],
        password : ['', Validators.required],
        tip: ['', Validators.required]
      })
  }

  onSubmit(){
    this.authService.login(this.loginForm.value.username, 
      this.loginForm.value.password, this.loginForm.value.tip)
      .subscribe((res: any)=>{
        if(res.success){
          localStorage.removeItem('userData')
          console.log(res);
          
          localStorage.setItem('userData', JSON.stringify(res.user));
          if(this.loginForm.value.tip == 'student'){
            this.router.navigate(['/student/home'])
          }
          else if(this.loginForm.value.tip == 'nastavnik'){
            this.router.navigate(['nastavnik/home'])
          }
        }
        else{
          console.log(res.message);
          
          this.errorMessage = res.message;
        }
      }    )
  }



}
