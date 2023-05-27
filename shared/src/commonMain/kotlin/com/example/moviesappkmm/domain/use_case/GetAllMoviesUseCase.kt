package com.example.moviesappkmm.domain.use_case

import com.example.moviesappkmm.domain.model.MovieModel
import com.example.moviesappkmm.domain.repo_interface.MovieRepo
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetAllMoviesUseCase : KoinComponent {
    private val repo: MovieRepo by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(page:Int) = repo.getAllMovies(page)
    }