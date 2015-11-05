/**
 * Created by krukov on 05.11.2015.
 */
Tapestry.Validator = {
  numeric : function(field, message) {
      var regexp = new RegExp('[0-9]');
      field.addValidator(function(value) {
          if (!regexp.test(value)) {
              throw message;
          }
      });
  }
};