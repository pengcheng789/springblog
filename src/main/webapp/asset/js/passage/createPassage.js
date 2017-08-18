/**
 * Created by pen on 17-8-14.
 */

function createPassage(params) {
    var form = document.createElement('form');

    form.setAttribute('method', 'post');
    form.setAttribute('action', '/springblog/passage/add');

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

function test(params) {
    for (var key in params) {
        if (params.hasOwnProperty(key)) {
            console.log(key + ' ' + params[key] + ' \n')
        }
    }
}
