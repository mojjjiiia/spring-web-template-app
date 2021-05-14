import { Injectable } from '@angular/core';
import { SpinnerComponent } from '../../spinner/spinner.component';

@Injectable({
  providedIn: 'root'
})
export class LockAppService {

  constructor() { }

  showSpinner() {
    SpinnerComponent.LOCK_APP = true;
  }

  hideSpinner() {
    SpinnerComponent.LOCK_APP = false;
  }
}
