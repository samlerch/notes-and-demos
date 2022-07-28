import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'description'
})
export class DescriptionPipe implements PipeTransform {

  transform(value: string | undefined): string {
    if(!value){
      return "No Description Available"
    }
    return value;
  }

}
