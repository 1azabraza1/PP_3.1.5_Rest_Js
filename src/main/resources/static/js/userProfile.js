$(async function () {
    await getUser()
})
function getUser() {
    let table = $('#CurrentUser tbody');
    table.empty();

    fetch("/api/admin/current").then(res => res.json())
        .then(data => {
            currentUser = data;
            console.log(data)

            let tabContent = `$(
                        <tr>
                            <td>${currentUser.id}</td>
                            <td>${currentUser.username}</td>
                            <td>${currentUser.age}</td>
                            <td>${currentUser.email}</td>
                            <td>${currentUser.roles.map(role => role.role.substring(5)).join(" ")}</td>
                        </tr>
                )`;
            table.append(tabContent);

            document.getElementById("headerUsername").innerText = currentUser.username;
            document.getElementById("headerUserRoles").innerText = currentUser.roles.map(role => role.role.substring(5)).join(" ");
        })
}