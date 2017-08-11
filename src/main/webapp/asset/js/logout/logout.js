/**
 * Created by pen on 17-8-11.
 */

function logout(parameterName, token) {
    var form = document.createElement('form');

    form.setAttribute('method', 'post');
    form.setAttribute('action', '/user/logout');

    var hiddenField = document.createElement('input');
    hiddenField.setAttribute('type', 'hidden');
    hiddenField.setAttribute('name', parameterName);
    hiddenField.setAttribute('value', token);

    form.appendChild(hiddenField);
    document.body.appendChild(form);

    form.submit();
}
