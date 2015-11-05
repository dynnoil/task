/**
 * Created by krukov on 05.11.2015.
 */
Tapestry.Validator.numeric = function(field, message) {

    Event.observe(field, 'keyup', function(){
        var value = this.value, first;
        if(value.length == 0)
            return;
        first = value.charAt(0);
        value = value.replace(/[^0-9]/g,'');
        if(first == '+')
            value = first + value;
        this.value = value;
        return true;
    });

    var regexp = new RegExp('[+0-9]+');
      field.addValidator(function(value) {
          if (!regexp.test(value)) {
              throw message;
          }
      });
};