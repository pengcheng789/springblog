/**
 * Created by pen on 17-8-15.
 */
function createForm(urlPath, params) {
    var form = document.createElement('form');

    form.setAttribute('method', 'post');
    form.setAttribute('action', urlPath);

    for (var key in params) {
        if (params.hasOwnProperty(key)) {
            var hiddenField = document.createElement('input');
            hiddenField.setAttribute('type', 'hidden');
            hiddenField.setAttribute('name', key);
            hiddenField.setAttribute('value', params[key]);
            form.appendChild(hiddenField);
        }
    }

    document.body.appendChild(form);

    form.submit();
}