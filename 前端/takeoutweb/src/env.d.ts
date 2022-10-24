interface ImportMetaEnv{
	readonly VITE_BACKEND_API_BASE_URL: string
	//more
}

interface ImportMeta {
	readonly env: ImportMetaEnv
}