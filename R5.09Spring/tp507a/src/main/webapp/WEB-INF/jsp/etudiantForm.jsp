<form action="/addStudent" method="post">
  <ul>
    <li>
      <label for="Nom">Nom&nbsp;:</label>
      <input type="text" id="nom" name="nom" />
    </li>
    <li>
      <label for="Prenom">Prenom&nbsp;:</label>
      <input type="text" id="prenom" name="prenom" />
    </li>
    <li>
      <label for="groupe">Groupe&nbsp;:</label>
      <textarea id="text" name="groupe"></textarea>
    </li>
    <li>
          <label for="age">Age&nbsp;:</label>
          <textarea id="int" name="age"></textarea>
        </li>
  </ul>
  <div class="button">
    <button type="submit">Ajouter l'étudiant'/button>
  </div>

</form>
