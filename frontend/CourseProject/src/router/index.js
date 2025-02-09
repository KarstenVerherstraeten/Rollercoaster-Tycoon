import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";

const router = createRouter({
	history: createWebHistory(import.meta.env.BASE_URL),
	routes: [
		{
			path: "/",
			name: "home",
			component: HomeView,
		},
		{
			path: "/detail/:id",
			name: "AttractionView",
			component: () => import("../views/AttractionView.vue"),
		},

		{
			path: "/create",
			name: "create",
			component: () => import("../views/CreateView.vue"),
		},
		{
			path: "/about",
			name: "about",
			component: () => import("../views/AboutView.vue"),
		},
		{
			path: "/CategoryView",
			name: "CategoryView",
			component: () => import("../views/CategoryView.vue"),
		},
		{
			path: "/CreateCategory",
			name: "CreateCategory",
			component: () => import("../views/CreateCategory.vue"),
		},
		{
			path: "/Breakdowns",
			name: "Breakdowns",
			component: () => import("../views/Breakdowns.vue"),
		},
	],
});

export default router;
