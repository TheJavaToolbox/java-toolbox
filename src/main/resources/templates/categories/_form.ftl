<div class="form-group">
    <label for="title" class="col-sm-2 control-label">Name</label>
    <div class="col-sm-10">
    <@spring.formInput "category.name",  "class='form-control'" />
    </div>
</div>
<div class="form-group">
    <label for="summary" class="col-sm-2 control-label">Group</label>
    <div class="col-sm-10">
    <@spring.formSingleSelect "category.groupId", groupsMap, "class='form-control'" />
    </div>
</div>
