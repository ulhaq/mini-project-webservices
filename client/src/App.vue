<template>
  <div class="container">
    <nav class="navbar navbar-expand-sm bg-light navbar-light">
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link :to="{name: 'index'}" class="nav-link">Home</router-link>
        </li>
        <li class="nav-item">
          <router-link :to="{name: 'indexMessage'}" class="nav-link">Messages</router-link>
        </li>
        <li class="nav-item">
          <router-link :to="{name: 'createMessage'}" class="nav-link">New Message</router-link>
        </li>
        <li class="nav-item">
          <router-link :to="{name: 'indexStudent'}" class="nav-link">Students</router-link>
        </li>
        <li class="nav-item">
          <router-link :to="{name: 'createStudent'}" class="nav-link">Create Student</router-link>
        </li>
      </ul>
    </nav>
    <br />
    <div>
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
  name: "app"
};
</script>