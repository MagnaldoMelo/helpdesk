import { Injectable } from '@angular/core';

@Injectable()
export class DialogService {

  confirm(message?: String) {
    return new Promise ( resolve => {
      return resolve(window.confirm(`message || 'Confirm ?'`));
    });
  }
}
